#ifndef CLIENTABSTRACTINTERFACE_H
#define CLIENTABSTRACTINTERFACE_H

#include <QObject>
#include <QPointer>
#include <QTcpSocket>

class ClientAbstractInterface : public QObject
{
    Q_OBJECT
public:
    explicit ClientAbstractInterface(QTcpSocket *mySocket, QObject *parent = nullptr);
protected:
    QPointer<QTcpSocket> _socket;
public slots:
    virtual void readyReadSlot();
    virtual void writingSlot();

signals:

};

#endif // CLIENTABSTRACTINTERFACE_H
