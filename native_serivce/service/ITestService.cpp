//#define LOG_NDEBUG 0
#include <utils/Log.h>
#include <binder/Parcel.h>
#include <ITestService.h>

namespace android
{


class BpTestService: public BpInterface<ITestService>
{
public:
    BpTestService(const sp<IBinder>& impl) : BpInterface<ITestService>(impl) {}

    virtual int setListener(sp<ITestServiceListener>& listener)
    {
        Parcel data, reply;
        data.writeInterfaceToken(ITestService::getInterfaceDescriptor());
        data.writeStrongBinder(IInterface::asBinder(listener));

        if(remote()->transact(TRANSACTION_setListener, data, &reply) != NO_ERROR)
        {
            ALOGE("setListener could not contact remote\n");
            return -1;
        }
        
        int32_t err = reply.readExceptionCode();
        if (err < 0) 
        {
            ALOGE("setListener caught exception %d\n", err);
            return -1;
        }
        
        return reply.readInt32();
    }

    virtual void unsetListener()
    {
        Parcel data, reply;
        data.writeInterfaceToken(ITestService::getInterfaceDescriptor());

        if(remote()->transact(TRANSACTION_unsetListener, data, &reply) != NO_ERROR)
        {
            ALOGE("unsetListener could not contact remote\n");
            return;
        }
        
        int32_t err = reply.readExceptionCode();
        if (err < 0) 
        {
            ALOGE("unsetListener caught exception %d\n", err);
            return;
        }
    }

    virtual void echo(const String16& txt)
    {
        ALOGE("[%s:%d] %s() TRANSACTION_setListener\n", __FILE__, __LINE__, __func__);

        Parcel data, reply;
        data.writeInterfaceToken(ITestService::getInterfaceDescriptor());
        data.writeString16(txt);
        
        if(remote()->transact(TRANSACTION_echo, data, &reply) != NO_ERROR)
        {
            ALOGE("echo() could not contact remote\n");
            return;
        }
        
        int32_t err = reply.readExceptionCode();
        if (err < 0) 
        {
            ALOGE("echo() caught exception %d\n", err);
            return;
        }
    }
};


IMPLEMENT_META_INTERFACE(TestService, TEST_SERVICE_NAME);

status_t BnTestService::onTransact(uint32_t code, const Parcel& data, Parcel* reply, uint32_t flags)
{
    switch(code)
    {
        case TRANSACTION_setListener:
        {
            ALOGE("[%s:%d] %s() TRANSACTION_setListener\n", __FILE__, __LINE__, __func__);
            CHECK_INTERFACE(ITestService, data, reply);
            sp<ITestServiceListener> listener = interface_cast<ITestServiceListener>(data.readStrongBinder());
            
            reply->writeInt32(setListener(listener));
            return NO_ERROR;
        }break;
        case TRANSACTION_unsetListener:
        {
            ALOGE("[%s:%d] %s() TRANSACTION_unsetListener\n", __FILE__, __LINE__, __func__);
            CHECK_INTERFACE(ITestService, data, reply);
            
            unsetListener();
            return NO_ERROR;
        }break;
        case TRANSACTION_echo:
        {
            ALOGE("[%s:%d] %s() TRANSACTION_echo\n", __FILE__, __LINE__, __func__);
            CHECK_INTERFACE(ITestService, data, reply);
            String16 txt = data.readString16();

            return NO_ERROR;
        }break;
    }
    return BBinder::onTransact(code, data, reply, flags);
}


};
