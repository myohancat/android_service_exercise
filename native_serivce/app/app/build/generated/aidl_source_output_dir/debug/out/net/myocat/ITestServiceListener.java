/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package net.myocat;
public interface ITestServiceListener extends android.os.IInterface
{
  /** Default implementation for ITestServiceListener. */
  public static class Default implements net.myocat.ITestServiceListener
  {
    @Override public void notifyCallback(int msgType, int ext1, int ext2) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements net.myocat.ITestServiceListener
  {
    private static final java.lang.String DESCRIPTOR = "net.myocat.ITestServiceListener";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an net.myocat.ITestServiceListener interface,
     * generating a proxy if needed.
     */
    public static net.myocat.ITestServiceListener asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof net.myocat.ITestServiceListener))) {
        return ((net.myocat.ITestServiceListener)iin);
      }
      return new net.myocat.ITestServiceListener.Stub.Proxy(obj);
    }
    @Override public android.os.IBinder asBinder()
    {
      return this;
    }
    @Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
    {
      java.lang.String descriptor = DESCRIPTOR;
      switch (code)
      {
        case INTERFACE_TRANSACTION:
        {
          reply.writeString(descriptor);
          return true;
        }
        case TRANSACTION_notifyCallback:
        {
          data.enforceInterface(descriptor);
          int _arg0;
          _arg0 = data.readInt();
          int _arg1;
          _arg1 = data.readInt();
          int _arg2;
          _arg2 = data.readInt();
          this.notifyCallback(_arg0, _arg1, _arg2);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements net.myocat.ITestServiceListener
    {
      private android.os.IBinder mRemote;
      Proxy(android.os.IBinder remote)
      {
        mRemote = remote;
      }
      @Override public android.os.IBinder asBinder()
      {
        return mRemote;
      }
      public java.lang.String getInterfaceDescriptor()
      {
        return DESCRIPTOR;
      }
      @Override public void notifyCallback(int msgType, int ext1, int ext2) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeInt(msgType);
          _data.writeInt(ext1);
          _data.writeInt(ext2);
          boolean _status = mRemote.transact(Stub.TRANSACTION_notifyCallback, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().notifyCallback(msgType, ext1, ext2);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static net.myocat.ITestServiceListener sDefaultImpl;
    }
    static final int TRANSACTION_notifyCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    public static boolean setDefaultImpl(net.myocat.ITestServiceListener impl) {
      // Only one user of this interface can use this function
      // at a time. This is a heuristic to detect if two different
      // users in the same process use this function.
      if (Stub.Proxy.sDefaultImpl != null) {
        throw new IllegalStateException("setDefaultImpl() called twice");
      }
      if (impl != null) {
        Stub.Proxy.sDefaultImpl = impl;
        return true;
      }
      return false;
    }
    public static net.myocat.ITestServiceListener getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public void notifyCallback(int msgType, int ext1, int ext2) throws android.os.RemoteException;
}
