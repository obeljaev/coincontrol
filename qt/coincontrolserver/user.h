#ifndef USER_H
#define USER_H

#include <QObject>
#include "QJsonDocument"
#include <QJsonObject>
#include <QJsonArray>
#include "clientabstractinterface.h"

struct UserType{
    int userId { 0 };
    QString userName;
    QString userPassword;
    UserType(int _userId, QString _userName, QString _userPassword):
        userId(_userId),
        userName(_userName),
        userPassword(_userPassword)
    {

    }
    void show(){
        qDebug()<<"userId:"<<userId
               <<"userName:"<<userName
              <<"userPassword:"<<userPassword;
    }

};
class User : public ClientAbstractInterface
{
    Q_OBJECT
public:
    explicit User(QTcpSocket* mySocket, QObject *parent = nullptr);
private:
    QJsonArray getUsers();
    bool setUser(UserType user);
public slots:
    void readyReadSlot() override;

signals:

};

#endif // USER_H
