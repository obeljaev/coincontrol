#ifndef CATEGORY_H
#define CATEGORY_H

#include <QObject>
#include "QJsonDocument"
#include <QJsonObject>
#include <QJsonArray>
#include "clientabstractinterface.h"

struct CategoryType{
    int categoryId { 0 };
    QString categoryName;
    int subCategoryId;
    QString subCategoryName;
    CategoryType(int _categoryId, QString _categoryName, int _subCategoryId, QString _subCategoryName):
        categoryId(_categoryId),
        categoryName(_categoryName),
        subCategoryId(_subCategoryId),
        subCategoryName(_subCategoryName)
    {

    }
    void show(){
        qDebug()<<"categoryId:"<<categoryId
               <<"categoryName:"<<categoryName
              <<"subCategoryId:"<<subCategoryId
             <<"subCategoryName:"<<subCategoryName;
    }

};

class Category : public ClientAbstractInterface
{
    Q_OBJECT
public:
    explicit Category(QTcpSocket* mySocket, QObject *parent = nullptr);
public slots:
    void readyReadSlot() override;
    void writingSlot() override;
signals:

};

#endif // CATEGORY_H
