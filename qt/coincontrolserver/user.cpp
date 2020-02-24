#include "user.h"
#include <QSqlQuery>

User::User(QTcpSocket *mySocket, QObject *parent) : ClientAbstractInterface(mySocket,parent)
{

}

QJsonArray User::getUsers()
{
    QJsonArray array;
    QSqlQuery query(QSqlDatabase::database());
    query.prepare("SELECT * FROM coin2.user");
    if(query.exec()){
        qDebug()<<"exec size="<<query.size();
        while(query.next()){
            UserType user(query.value(0).toInt(),
                           query.value(1).toString(),
                           query.value(2).toString()
                           );
            QJsonObject jsonObj;
            jsonObj["userId"] = user.userId;
            jsonObj["userName"] = user.userName;
            jsonObj["userPassword"] = user.userPassword;
            array.append(jsonObj);
        }
    }else{
        qCritical()<<"don't exec getUsers";
    }
    return array;
}

bool User::setUser(UserType user)
{
    QSqlQuery query(QSqlDatabase::database());
    query.prepare("INSERT INTO coin2.user (user_name, user_password) VALUES (?, ?)");
    query.bindValue(0,user.userName);
    query.bindValue(1,user.userPassword);
    if(query.exec()){
        return true;
    }else{
        qCritical()<<"don't exec setUsers";
        return false;
    }
}

void User::readyReadSlot()
{
    qDebug()<<"User::readyRead";
    QByteArray buf(_socket->readAll());
    int startNum = buf.indexOf("{");
    QByteArray messType = buf.mid(0,startNum);
    qDebug()<<messType;
    if(messType == "post")
    {
        buf = buf.right(buf.size() - startNum);
        QJsonParseError strErr;
        QJsonDocument _readingJson(QJsonDocument::fromJson(buf,&strErr));
        qDebug()<<strErr.errorString();
        if(_readingJson.isObject()){
            QJsonObject _readObj(_readingJson.object());
            if (_readObj.contains("userId") &&
                    _readObj.contains("userName") &&
                    _readObj.contains("userPassword")){
                UserType user(
                            _readObj["userId"].toInt(),
                        _readObj["userName"].toString(),
                        _readObj["userPassword"].toString()
                        );
                user.show();
                if(setUser(user))
                    _socket->write("true");
                else
                    _socket->write("false");
            }
        }
    }else if(messType == "get")
    {
        QJsonArray array = getUsers();
        QJsonDocument obj1(array);
        _socket->write(obj1.toJson());
    }
    _socket->flush();
    _socket->close();
}
