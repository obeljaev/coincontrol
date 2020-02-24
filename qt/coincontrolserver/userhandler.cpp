#include "userhandler.h"

UserHandler::UserHandler(int port, QObject *parent) :
    ServerAbstractInterface(port, parent)
{

}

void UserHandler::newConnectionSlot()
{
    qDebug()<<"UserHandler::connected"<<_port;
    User *user = new User(_server->nextPendingConnection(), this);
}
