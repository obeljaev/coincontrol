#ifndef CATEGORYHANDLER_H
#define CATEGORYHANDLER_H

#include <QObject>
#include "abstractinterface.h"
#include "category.h"

class CategoryHandler : public ServerAbstractInterface
{
    Q_OBJECT
public:
    explicit CategoryHandler(int port, QObject *parent = nullptr);
private:
private slots:
    void newConnectionSlot() override;
signals:

};

#endif // CATEGORYHANDLER_H
