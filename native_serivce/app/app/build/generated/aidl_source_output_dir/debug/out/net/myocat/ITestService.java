/*
 * This file is auto-generated.  DO NOT MODIFY.
 */
package net.myocat;
public interface ITestService extends android.os.IInterface
{
  /** Default implementation for ITestService. */
  public static class Default implements net.myocat.ITestService
  {
    @Override public int setListener(net.myocat.ITestServiceListener listener) throws android.os.RemoteException
    {
      return 0;
    }
    @Override public void unsetListener() throws android.os.RemoteException
    {
    }
    @Override public void echo(java.lang.String txt) throws android.os.RemoteException
    {
    }
    @Override
    public android.os.IBinder asBinder() {
      return null;
    }
  }
  /** Local-side IPC implementation stub class. */
  public static abstract class Stub extends android.os.Binder implements net.myocat.ITestService
  {
    private static final java.lang.String DESCRIPTOR = "net.myocat.ITestService";
    /** Construct the stub at attach it to the interface. */
    public Stub()
    {
      this.attachInterface(this, DESCRIPTOR);
    }
    /**
     * Cast an IBinder object into an net.myocat.ITestService interface,
     * generating a proxy if needed.
     */
    public static net.myocat.ITestService asInterface(android.os.IBinder obj)
    {
      if ((obj==null)) {
        return null;
      }
      android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
      if (((iin!=null)&&(iin instanceof net.myocat.ITestService))) {
        return ((net.myocat.ITestService)iin);
      }
      return new net.myocat.ITestService.Stub.Proxy(obj);
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
        case TRANSACTION_setListener:
        {
          data.enforceInterface(descriptor);
          net.myocat.ITestServiceListener _arg0;
          _arg0 = net.myocat.ITestServiceListener.Stub.asInterface(data.readStrongBinder());
          int _result = this.setListener(_arg0);
          reply.writeNoException();
          reply.writeInt(_result);
          return true;
        }
        case TRANSACTION_unsetListener:
        {
          data.enforceInterface(descriptor);
          this.unsetListener();
          reply.writeNoException();
          return true;
        }
        case TRANSACTION_echo:
        {
          data.enforceInterface(descriptor);
          java.lang.String _arg0;
          _arg0 = data.readString();
          this.echo(_arg0);
          reply.writeNoException();
          return true;
        }
        default:
        {
          return super.onTransact(code, data, reply, flags);
        }
      }
    }
    private static class Proxy implements net.myocat.ITestService
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
      @Override public int setListener(net.myocat.ITestServiceListener listener) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        int _result;
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
          boolean _status = mRemote.transact(Stub.TRANSACTION_setListener, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            return getDefaultImpl().setListener(listener);
          }
          _reply.readException();
          _result = _reply.readInt();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
        return _result;
      }
      @Override public void unsetListener() throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          boolean _status = mRemote.transact(Stub.TRANSACTION_unsetListener, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().unsetListener();
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      @Override public void echo(java.lang.String txt) throws android.os.RemoteException
      {
        android.os.Parcel _data = android.os.Parcel.obtain();
        android.os.Parcel _reply = android.os.Parcel.obtain();
        try {
          _data.writeInterfaceToken(DESCRIPTOR);
          _data.writeString(txt);
          boolean _status = mRemote.transact(Stub.TRANSACTION_echo, _data, _reply, 0);
          if (!_status && getDefaultImpl() != null) {
            getDefaultImpl().echo(txt);
            return;
          }
          _reply.readException();
        }
        finally {
          _reply.recycle();
          _data.recycle();
        }
      }
      public static net.myocat.ITestService sDefaultImpl;
    }
    static final int TRANSACTION_setListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    static final int TRANSACTION_unsetListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    static final int TRANSACTION_echo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    public static boolean setDefaultImpl(net.myocat.ITestService impl) {
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
    public static net.myocat.ITestService getDefaultImpl() {
      return Stub.Proxy.sDefaultImpl;
    }
  }
  public int setListener(net.myocat.ITestServiceListener listener) throws android.os.RemoteException;
  public void unsetListener() throws android.os.RemoteException;
  public void echo(java.lang.String txt) throws android.os.RemoteException;
}
