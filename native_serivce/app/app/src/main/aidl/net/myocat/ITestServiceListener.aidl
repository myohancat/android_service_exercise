// ITestServiceListener.aidl
package net.myocat;

interface ITestServiceListener {
    void notifyCallback(int msgType, int ext1, int ext2);
}