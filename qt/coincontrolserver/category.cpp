#include "category.h"

Category::Category(QTcpSocket *mySocket, QObject *parent) : ClientAbstractInterface(mySocket,parent)
{

}

void Category::readyReadSlot()
{
    qDebug()<<"readyRead";
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
            if (_readObj.contains("categoryName") &&
                    _readObj.contains("categoryId") &&
                    _readObj.contains("subCategoryName") &&
                    _readObj.contains("subCategoryId")){
                CategoryType category(
                            _readObj["categoryId"].toInt(),
                        _readObj["categoryName"].toString(),
                        _readObj["subCategoryId"].toInt(),
                        _readObj["subCategoryName"].toString()
                        );
                category.show();
            }
        }
    }else if(messType == "get")
    {
        CategoryType category(1,"test0",5,"subTest0");
        QJsonObject jsonObj;
        jsonObj["categoryId"] = category.categoryId;
        jsonObj["categoryName"] = category.categoryName;
        jsonObj["subCategoryId"] = category.subCategoryId;
        jsonObj["subCategoryName"] = category.subCategoryName;
        QJsonArray array;
        array.append(jsonObj);
        array.append(jsonObj);
        QJsonDocument obj1(array);
        _socket->write(obj1.toJson());
    }
    _socket->flush();
    _socket->close();
}

void Category::writingSlot()
{

}
