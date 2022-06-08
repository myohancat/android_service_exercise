// ITestService.aidl
package net.myocat;

import net.myocat.ITestServiceListener;

interface ITestService {
    int setListener(ITestServiceListener listener);
    void unsetListener();
    void echo(String txt);
}