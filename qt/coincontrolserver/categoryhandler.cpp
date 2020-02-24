#include "categoryhandler.h"

CategoryHandler::CategoryHandler(int port, QObject *parent) :
    ServerAbstractInterface(port, parent)
{

}

void CategoryHandler::newConnectionSlot()
{
    qDebug()<<"CategoryHandler::connected"<<_port;

    Category *category = new Category(_server->nextPendingConnection(), this);

}



