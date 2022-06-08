#include <binder/ProcessState.h>
#include <binder/IPCThreadState.h>
#include <binder/IServiceManager.h>
#include <TestService.h>


using namespace android;

int main(int argc, char *argv[])
{
    TestService::getInstance();

    ProcessState::self()->startThreadPool();
    IPCThreadState::self()->joinThreadPool();

    return 0;
}

