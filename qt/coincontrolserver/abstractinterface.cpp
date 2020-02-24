#include "abstractinterface.h"

ServerAbstractInterface::ServerAbstractInterface(int port, QObject *parent) :
    QObject(parent),
    _port(port)
{
    QTimer::singleShot(1,this,SLOT(initSlot()));
}

void ServerAbstractInterface::initSlot()
{
    _server = new QTcpServer(this);
    connect(_server, SIGNAL(newConnection()),
                this, SLOT(newConnectionSlot())
            );
    qDebug()<<"connecting"<<_port;
    _server->listen(QHostAddress::Any, _port);
}

void ServerAbstractInterface::newConnectionSlot()
{

}

void ServerAbstractInterface::disconnectedSlot()
{
    qDebug()<<"disconnected"<<_port;
}
