#include "clientabstractinterface.h"

ClientAbstractInterface::ClientAbstractInterface(QTcpSocket *mySocket, QObject *parent) : QObject(parent), _socket(mySocket)
{
    connect(_socket,SIGNAL(disconnected()),
            _socket,SLOT(deleteLater())
            );
    connect(_socket,SIGNAL(readyRead()),
            this,SLOT(readyReadSlot())
            );
}

void ClientAbstractInterface::readyReadSlot()
{

}

void ClientAbstractInterface::writingSlot()
{

}
