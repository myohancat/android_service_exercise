//#define LOG_NDEBUG 0
#define LOG_TAG "ITestServiceListener"
#include <utils/Log.h>
#include <binder/Parcel.h>
#include <ITestServiceListener.h>

namespace android
{

class BpTestServiceListener: public BpInterface<ITestServiceListener>
{
public:
    BpTestServiceListener(const sp<IBinder>& impl)
            :BpInterface<ITestServiceListener>(impl) {}

    virtual void notifyCallback(int32_t msgType, int32_t ext1, int32_t ext2)
    {
        ALOGV(">>>>> notifyCallback() called !!!");
        Parcel data, reply;
        data.writeInterfaceToken(
            ITestServiceListener::getInterfaceDescriptor());
    
        data.writeInt32(msgType);
        data.writeInt32(ext1);
        data.writeInt32(ext2);
        
        if(remote()->transact(TRANSACTION_notifyCallback, data, &reply) != NO_ERROR)
        {
            ALOGE("test_func could not contact remote\n");
        }
    }

};


IMPLEMENT_META_INTERFACE(TestServiceListener, TEST_SERVICE_LISTENER_NAME);


status_t BnTestServiceListener::onTransact(uint32_t code, const Parcel& data, Parcel* reply, uint32_t flags)
{
    switch(code) 
    {
        case TRANSACTION_notifyCallback: 
        {
            ALOGV("TRANSACTION_notifyCallback");
            CHECK_INTERFACE(ITestServiceListener, data, reply);
            int32_t msgType = data.readInt32();
            int32_t ext1 = data.readInt32();
            int32_t ext2 = data.readInt32();
            notifyCallback(msgType, ext1, ext2);
            return NO_ERROR;
        } 
        break;
        default:
            return BBinder::onTransact(code, data, reply, flags);
    }
}

};
