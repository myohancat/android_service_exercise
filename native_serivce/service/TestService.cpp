#define LOG_NDEBUG 0
#define LOG_TAG "TEST_SERVICE"

#include <utils/Log.h>

#include <binder/ProcessState.h>
#include <binder/IPCThreadState.h>

#include <binder/IServiceManager.h>

#include <binder/IServiceManager.h>
#include <binder/Parcel.h>

#include "TestService.h"

namespace android
{

TestService* TestService::sService = NULL;

TestService* TestService::getInstance()
{
    if(sService == NULL)
    {
        sService = new TestService();
        
        defaultServiceManager()->addService(String16(TEST_SERVICE_NAME), sService);
    }

    return sService;
}

int TestService::setListener(sp<ITestServiceListener>& listener)
{
    if(mListener != NULL)
        mListener = NULL;

    mListener = listener;

    return 0;
}

void TestService::unsetListener()
{
    if(mListener != NULL)
        mListener = NULL;
}

void TestService::echo(const String16& txt)
{
    // TBD. IMPLMENETS HERE
}

TestService::TestService()
{
    mListener = NULL;
}

TestService::~TestService()
{
    mListener = NULL;
}

}; // namespace android
