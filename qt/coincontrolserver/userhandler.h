#ifndef USERHANDLER_H
#define USERHANDLER_H

#include <QObject>
#include "abstractinterface.h"
#include "user.h"

class UserHandler : public ServerAbstractInterface
{
    Q_OBJECT
public:
    explicit UserHandler(int port, QObject *parent = nullptr);
private slots:
    void newConnectionSlot() override;

signals:

};

#endif // USERHANDLER_H
