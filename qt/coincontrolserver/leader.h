#ifndef LEADER_H
#define LEADER_H

#include <QObject>
#include <QPointer>
#include <QTimer>
#include <QDebug>
#include <QSqlDatabase>
#include "categoryhandler.h"
#include "userhandler.h"

class Leader : public QObject
{
    Q_OBJECT
public:
    explicit Leader(QObject *parent = nullptr);
private:
    QSqlDatabase _db;
    bool _isDbOpen { false };
    QPointer<CategoryHandler> _categoryHandler;
    QPointer<UserHandler> _userHandler;

    bool openDb();
public slots:
    void initSlot();
signals:

};

#endif // LEADER_H
