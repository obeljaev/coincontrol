#include <QCoreApplication>
#include "leader.h"

int main(int argc, char *argv[])
{
    QCoreApplication a(argc, argv);

    Leader _leader;

    return a.exec();
}
