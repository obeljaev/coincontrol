#ifndef ABSTRACTINTERFACE_H
#define ABSTRACTINTERFACE_H

#include <QObject>
#include <QtNetwork>
#include <QPointer>
#include <QTimer>
#include <QTcpServer>
#include <QDebug>

class ServerAbstractInterface : public QObject
{
    Q_OBJECT
public:
    explicit ServerAbstractInterface(int port, QObject *parent = nullptr);
protected:
    QPointer<QTcpServer> _server;
    int _port { 0 };
public slots:
    void initSlot();
    virtual void newConnectionSlot();
    void disconnectedSlot();
signals:

};

#endif // ABSTRACTINTERFACE_H
