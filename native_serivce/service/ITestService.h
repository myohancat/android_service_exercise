#ifndef __INTERFACE_TEST_SERVICE_H_
#define __INTERFACE_TEST_SERVICE_H_

#include <utils/RefBase.h>
#include <binder/IInterface.h>
#include <binder/Parcel.h>

#include "ITestServiceListener.h"
#include <utils/String16.h>

#define TEST_SERVICE_NAME  "net.myocat.ITestService"

namespace android 
{

enum
{
    TRANSACTION_setListener = IBinder::FIRST_CALL_TRANSACTION,
    TRANSACTION_unsetListener,
    TRANSACTION_echo,
};


class ITestService : public IInterface
{
public:
    DECLARE_META_INTERFACE(TestService);

    virtual int setListener(sp<ITestServiceListener>& listener) = 0;
    virtual void unsetListener() = 0;
    virtual void echo(const String16& txt) = 0;
};


class BnTestService : public BnInterface<ITestService>
{
public:
    virtual status_t onTransact( uint32_t code, const Parcel& data,
                    Parcel* reply, uint32_t flags = 0);
};

}; // namespace android

#endif /*__INTERFACE_TEST_SERVICE_H_*/
