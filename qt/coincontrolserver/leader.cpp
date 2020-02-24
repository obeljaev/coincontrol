#include "leader.h"

Leader::Leader(QObject *parent) : QObject(parent)
{
    QTimer::singleShot(1,this,SLOT(initSlot()));
}

bool Leader::openDb()
{
    _db = QSqlDatabase::addDatabase("QPSQL");
    _db.setPort(5432);
    _db.setHostName("localhost");
    _db.setUserName("oleg");
    _db.setPassword("home");
    _db.setDatabaseName("postgres");
    _isDbOpen = _db.open();
    return  _isDbOpen;
}

void Leader::initSlot()
{
    if(!openDb()){
        qCritical()<<"DataBase don't opened";
        return;
    }
    _userHandler = new UserHandler(30000, this);
    _categoryHandler = new CategoryHandler(30001, this);
}
