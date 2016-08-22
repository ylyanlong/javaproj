/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.yl.thrift.demo;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2016-6-24")
public class UserInfoService {

  public interface Iface {

    public UserInfoRsp getUserInfo(UserInfoReq req) throws UserInfoReqException, TException;

  }

  public interface AsyncIface {

    public void getUserInfo(UserInfoReq req, AsyncMethodCallback resultHandler) throws TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public UserInfoRsp getUserInfo(UserInfoReq req) throws UserInfoReqException, TException
    {
      send_getUserInfo(req);
      return recv_getUserInfo();
    }

    public void send_getUserInfo(UserInfoReq req) throws TException
    {
      getUserInfo_args args = new getUserInfo_args();
      args.setReq(req);
      sendBase("getUserInfo", args);
    }

    public UserInfoRsp recv_getUserInfo() throws UserInfoReqException, TException
    {
      getUserInfo_result result = new getUserInfo_result();
      receiveBase(result, "getUserInfo");
      if (result.isSetSuccess()) {
        return result.success;
      }
      if (result.e != null) {
        throw result.e;
      }
      throw new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.MISSING_RESULT, "getUserInfo failed: unknown result");
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void getUserInfo(UserInfoReq req, AsyncMethodCallback resultHandler) throws TException {
      checkReady();
      getUserInfo_call method_call = new getUserInfo_call(req, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class getUserInfo_call extends org.apache.thrift.async.TAsyncMethodCall {
      private UserInfoReq req;
      public getUserInfo_call(UserInfoReq req, AsyncMethodCallback resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.req = req;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("getUserInfo", org.apache.thrift.protocol.TMessageType.CALL, 0));
        getUserInfo_args args = new getUserInfo_args();
        args.setReq(req);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public UserInfoRsp getResult() throws UserInfoReqException, TException {
        if (getState() != State.RESPONSE_READ) {
          throw new IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return (new Client(prot)).recv_getUserInfo();
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> getProcessMap(Map<String,  org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("getUserInfo", new getUserInfo());
      return processMap;
    }

    public static class getUserInfo<I extends Iface> extends org.apache.thrift.ProcessFunction<I, getUserInfo_args> {
      public getUserInfo() {
        super("getUserInfo");
      }

      public getUserInfo_args getEmptyArgsInstance() {
        return new getUserInfo_args();
      }

      protected boolean isOneway() {
        return false;
      }

      public getUserInfo_result getResult(I iface, getUserInfo_args args) throws TException {
        getUserInfo_result result = new getUserInfo_result();
        try {
          result.success = iface.getUserInfo(args.req);
        } catch (UserInfoReqException e) {
          result.e = e;
        }
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new HashMap<String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(Map<String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("getUserInfo", new getUserInfo());
      return processMap;
    }

    public static class getUserInfo<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, getUserInfo_args, UserInfoRsp> {
      public getUserInfo() {
        super("getUserInfo");
      }

      public getUserInfo_args getEmptyArgsInstance() {
        return new getUserInfo_args();
      }

      public AsyncMethodCallback<UserInfoRsp> getResultHandler(final AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new AsyncMethodCallback<UserInfoRsp>() { 
          public void onComplete(UserInfoRsp o) {
            getUserInfo_result result = new getUserInfo_result();
            result.success = o;
            try {
              fcall.sendResponse(fb,result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
              return;
            } catch (Exception e) {
              LOGGER.error("Exception writing to internal frame buffer", e);
            }
            fb.close();
          }
          public void onError(Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TBase msg;
            getUserInfo_result result = new getUserInfo_result();
            if (e instanceof UserInfoReqException) {
                        result.e = (UserInfoReqException) e;
                        result.setEIsSet(true);
                        msg = result;
            }
             else 
            {
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TBase)new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
              return;
            } catch (Exception ex) {
              LOGGER.error("Exception writing to internal frame buffer", ex);
            }
            fb.close();
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, getUserInfo_args args, AsyncMethodCallback<UserInfoRsp> resultHandler) throws TException {
        iface.getUserInfo(args.req,resultHandler);
      }
    }

  }

  public static class getUserInfo_args implements org.apache.thrift.TBase<getUserInfo_args, getUserInfo_args._Fields>, java.io.Serializable, Cloneable, Comparable<getUserInfo_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getUserInfo_args");

    private static final org.apache.thrift.protocol.TField REQ_FIELD_DESC = new org.apache.thrift.protocol.TField("req", org.apache.thrift.protocol.TType.STRUCT, (short)1);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new getUserInfo_argsStandardSchemeFactory());
      schemes.put(TupleScheme.class, new getUserInfo_argsTupleSchemeFactory());
    }

    public UserInfoReq req; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      REQ((short)1, "req");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // REQ
            return REQ;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.REQ, new org.apache.thrift.meta_data.FieldMetaData("req", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, UserInfoReq.class)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getUserInfo_args.class, metaDataMap);
    }

    public getUserInfo_args() {
    }

    public getUserInfo_args(
      UserInfoReq req)
    {
      this();
      this.req = req;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getUserInfo_args(getUserInfo_args other) {
      if (other.isSetReq()) {
        this.req = new UserInfoReq(other.req);
      }
    }

    public getUserInfo_args deepCopy() {
      return new getUserInfo_args(this);
    }

    @Override
    public void clear() {
      this.req = null;
    }

    public UserInfoReq getReq() {
      return this.req;
    }

    public getUserInfo_args setReq(UserInfoReq req) {
      this.req = req;
      return this;
    }

    public void unsetReq() {
      this.req = null;
    }

    /** Returns true if field req is set (has been assigned a value) and false otherwise */
    public boolean isSetReq() {
      return this.req != null;
    }

    public void setReqIsSet(boolean value) {
      if (!value) {
        this.req = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case REQ:
        if (value == null) {
          unsetReq();
        } else {
          setReq((UserInfoReq)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case REQ:
        return getReq();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case REQ:
        return isSetReq();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getUserInfo_args)
        return this.equals((getUserInfo_args)that);
      return false;
    }

    public boolean equals(getUserInfo_args that) {
      if (that == null)
        return false;

      boolean this_present_req = true && this.isSetReq();
      boolean that_present_req = true && that.isSetReq();
      if (this_present_req || that_present_req) {
        if (!(this_present_req && that_present_req))
          return false;
        if (!this.req.equals(that.req))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_req = true && (isSetReq());
      list.add(present_req);
      if (present_req)
        list.add(req);

      return list.hashCode();
    }

    @Override
    public int compareTo(getUserInfo_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetReq()).compareTo(other.isSetReq());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetReq()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.req, other.req);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getUserInfo_args(");
      boolean first = true;

      sb.append("req:");
      if (this.req == null) {
        sb.append("null");
      } else {
        sb.append(this.req);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
      // check for sub-struct validity
      if (req != null) {
        req.validate();
      }
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class getUserInfo_argsStandardSchemeFactory implements SchemeFactory {
      public getUserInfo_argsStandardScheme getScheme() {
        return new getUserInfo_argsStandardScheme();
      }
    }

    private static class getUserInfo_argsStandardScheme extends StandardScheme<getUserInfo_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, getUserInfo_args struct) throws TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // REQ
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.req = new UserInfoReq();
                struct.req.read(iprot);
                struct.setReqIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, getUserInfo_args struct) throws TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.req != null) {
          oprot.writeFieldBegin(REQ_FIELD_DESC);
          struct.req.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class getUserInfo_argsTupleSchemeFactory implements SchemeFactory {
      public getUserInfo_argsTupleScheme getScheme() {
        return new getUserInfo_argsTupleScheme();
      }
    }

    private static class getUserInfo_argsTupleScheme extends TupleScheme<getUserInfo_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, getUserInfo_args struct) throws TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetReq()) {
          optionals.set(0);
        }
        oprot.writeBitSet(optionals, 1);
        if (struct.isSetReq()) {
          struct.req.write(oprot);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, getUserInfo_args struct) throws TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(1);
        if (incoming.get(0)) {
          struct.req = new UserInfoReq();
          struct.req.read(iprot);
          struct.setReqIsSet(true);
        }
      }
    }

  }

  public static class getUserInfo_result implements org.apache.thrift.TBase<getUserInfo_result, getUserInfo_result._Fields>, java.io.Serializable, Cloneable, Comparable<getUserInfo_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("getUserInfo_result");

    private static final org.apache.thrift.protocol.TField SUCCESS_FIELD_DESC = new org.apache.thrift.protocol.TField("success", org.apache.thrift.protocol.TType.STRUCT, (short)0);
    private static final org.apache.thrift.protocol.TField E_FIELD_DESC = new org.apache.thrift.protocol.TField("e", org.apache.thrift.protocol.TType.STRUCT, (short)1);

    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
    static {
      schemes.put(StandardScheme.class, new getUserInfo_resultStandardSchemeFactory());
      schemes.put(TupleScheme.class, new getUserInfo_resultTupleSchemeFactory());
    }

    public UserInfoRsp success; // required
    public UserInfoReqException e; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      SUCCESS((short)0, "success"),
      E((short)1, "e");

      private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

      static {
        for (_Fields field : EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 0: // SUCCESS
            return SUCCESS;
          case 1: // E
            return E;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final String _fieldName;

      _Fields(short thriftId, String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.SUCCESS, new org.apache.thrift.meta_data.FieldMetaData("success", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, UserInfoRsp.class)));
      tmpMap.put(_Fields.E, new org.apache.thrift.meta_data.FieldMetaData("e", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT)));
      metaDataMap = Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(getUserInfo_result.class, metaDataMap);
    }

    public getUserInfo_result() {
    }

    public getUserInfo_result(
      UserInfoRsp success,
      UserInfoReqException e)
    {
      this();
      this.success = success;
      this.e = e;
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public getUserInfo_result(getUserInfo_result other) {
      if (other.isSetSuccess()) {
        this.success = new UserInfoRsp(other.success);
      }
      if (other.isSetE()) {
        this.e = new UserInfoReqException(other.e);
      }
    }

    public getUserInfo_result deepCopy() {
      return new getUserInfo_result(this);
    }

    @Override
    public void clear() {
      this.success = null;
      this.e = null;
    }

    public UserInfoRsp getSuccess() {
      return this.success;
    }

    public getUserInfo_result setSuccess(UserInfoRsp success) {
      this.success = success;
      return this;
    }

    public void unsetSuccess() {
      this.success = null;
    }

    /** Returns true if field success is set (has been assigned a value) and false otherwise */
    public boolean isSetSuccess() {
      return this.success != null;
    }

    public void setSuccessIsSet(boolean value) {
      if (!value) {
        this.success = null;
      }
    }

    public UserInfoReqException getE() {
      return this.e;
    }

    public getUserInfo_result setE(UserInfoReqException e) {
      this.e = e;
      return this;
    }

    public void unsetE() {
      this.e = null;
    }

    /** Returns true if field e is set (has been assigned a value) and false otherwise */
    public boolean isSetE() {
      return this.e != null;
    }

    public void setEIsSet(boolean value) {
      if (!value) {
        this.e = null;
      }
    }

    public void setFieldValue(_Fields field, Object value) {
      switch (field) {
      case SUCCESS:
        if (value == null) {
          unsetSuccess();
        } else {
          setSuccess((UserInfoRsp)value);
        }
        break;

      case E:
        if (value == null) {
          unsetE();
        } else {
          setE((UserInfoReqException)value);
        }
        break;

      }
    }

    public Object getFieldValue(_Fields field) {
      switch (field) {
      case SUCCESS:
        return getSuccess();

      case E:
        return getE();

      }
      throw new IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new IllegalArgumentException();
      }

      switch (field) {
      case SUCCESS:
        return isSetSuccess();
      case E:
        return isSetE();
      }
      throw new IllegalStateException();
    }

    @Override
    public boolean equals(Object that) {
      if (that == null)
        return false;
      if (that instanceof getUserInfo_result)
        return this.equals((getUserInfo_result)that);
      return false;
    }

    public boolean equals(getUserInfo_result that) {
      if (that == null)
        return false;

      boolean this_present_success = true && this.isSetSuccess();
      boolean that_present_success = true && that.isSetSuccess();
      if (this_present_success || that_present_success) {
        if (!(this_present_success && that_present_success))
          return false;
        if (!this.success.equals(that.success))
          return false;
      }

      boolean this_present_e = true && this.isSetE();
      boolean that_present_e = true && that.isSetE();
      if (this_present_e || that_present_e) {
        if (!(this_present_e && that_present_e))
          return false;
        if (!this.e.equals(that.e))
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      List<Object> list = new ArrayList<Object>();

      boolean present_success = true && (isSetSuccess());
      list.add(present_success);
      if (present_success)
        list.add(success);

      boolean present_e = true && (isSetE());
      list.add(present_e);
      if (present_e)
        list.add(e);

      return list.hashCode();
    }

    @Override
    public int compareTo(getUserInfo_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = Boolean.valueOf(isSetSuccess()).compareTo(other.isSetSuccess());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetSuccess()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.success, other.success);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = Boolean.valueOf(isSetE()).compareTo(other.isSetE());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetE()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.e, other.e);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
      schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
      schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
      }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder("getUserInfo_result(");
      boolean first = true;

      sb.append("success:");
      if (this.success == null) {
        sb.append("null");
      } else {
        sb.append(this.success);
      }
      first = false;
      if (!first) sb.append(", ");
      sb.append("e:");
      if (this.e == null) {
        sb.append("null");
      } else {
        sb.append(this.e);
      }
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws TException {
      // check for required fields
      // check for sub-struct validity
      if (success != null) {
        success.validate();
      }
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class getUserInfo_resultStandardSchemeFactory implements SchemeFactory {
      public getUserInfo_resultStandardScheme getScheme() {
        return new getUserInfo_resultStandardScheme();
      }
    }

    private static class getUserInfo_resultStandardScheme extends StandardScheme<getUserInfo_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, getUserInfo_result struct) throws TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 0: // SUCCESS
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.success = new UserInfoRsp();
                struct.success.read(iprot);
                struct.setSuccessIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 1: // E
              if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
                struct.e = new UserInfoReqException();
                struct.e.read(iprot);
                struct.setEIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, getUserInfo_result struct) throws TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        if (struct.success != null) {
          oprot.writeFieldBegin(SUCCESS_FIELD_DESC);
          struct.success.write(oprot);
          oprot.writeFieldEnd();
        }
        if (struct.e != null) {
          oprot.writeFieldBegin(E_FIELD_DESC);
          struct.e.write(oprot);
          oprot.writeFieldEnd();
        }
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class getUserInfo_resultTupleSchemeFactory implements SchemeFactory {
      public getUserInfo_resultTupleScheme getScheme() {
        return new getUserInfo_resultTupleScheme();
      }
    }

    private static class getUserInfo_resultTupleScheme extends TupleScheme<getUserInfo_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, getUserInfo_result struct) throws TException {
        TTupleProtocol oprot = (TTupleProtocol) prot;
        BitSet optionals = new BitSet();
        if (struct.isSetSuccess()) {
          optionals.set(0);
        }
        if (struct.isSetE()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetSuccess()) {
          struct.success.write(oprot);
        }
        if (struct.isSetE()) {
          struct.e.write(oprot);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, getUserInfo_result struct) throws TException {
        TTupleProtocol iprot = (TTupleProtocol) prot;
        BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.success = new UserInfoRsp();
          struct.success.read(iprot);
          struct.setSuccessIsSet(true);
        }
        if (incoming.get(1)) {
          struct.e = new UserInfoReqException();
          struct.e.read(iprot);
          struct.setEIsSet(true);
        }
      }
    }

  }

}
