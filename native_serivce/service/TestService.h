#ifndef __TEST_SERVICE_H_
#define __TEST_SERVICE_H_

#include <ITestService.h>
#include <ITestServiceListener.h>
#include <utils/Log.h>
#include <utils/String16.h>

namespace android
{

class TestService : public BnTestService
{
public:
    static TestService* getInstance();

    int  setListener(sp<ITestServiceListener>& listener);
    void unsetListener();

    void echo(const String16& txt);

private:
    static TestService* sService;

    TestService();
    virtual ~TestService();

    sp<ITestServiceListener> mListener;
};


}; // namespace android

#endif /* __TEST_SERVICE_H_ */
