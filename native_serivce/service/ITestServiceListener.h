#ifndef __INTERFACE_TEST_SERVICE_LISTENER_H_
#define __INTERFACE_TEST_SERVICE_LISTENER_H_

#include <utils/RefBase.h>
#include <binder/IInterface.h>
#include <binder/Parcel.h>

#define TEST_SERVICE_LISTENER_NAME "net.myocat.ITestServiceListener"

namespace android 
{

enum
{
    TRANSACTION_notifyCallback = IBinder::FIRST_CALL_TRANSACTION
};

class ITestServiceListener : public IInterface
{
public:
    DECLARE_META_INTERFACE(TestServiceListener);

    virtual void notifyCallback(int32_t msgType, int32_t ext1, int32_t ext2) = 0;
};


class BnTestServiceListener : public BnInterface<ITestServiceListener>
{
public:
    virtual status_t onTransact( uint32_t code, const Parcel& data,
                    Parcel* reply, uint32_t flags = 0) = 0;
};


}; // namespace android

#endif /*__INTERFACE_TEST_SERVICE_LISTENER_H_*/
