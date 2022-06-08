LOCAL_PATH:=$(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := TestService
LOCAL_MODULE_TAGS := optional
LOCAL_PROPRIETARY_MODULE := true
LOCAL_SRC_FILES := \
	ITestServiceListener.cpp \
	ITestService.cpp \
	TestService.cpp \
	main_TestService.cpp \

LOCAL_C_INCLUDES:= $(VENDOR_SDK_INCLUDES)
LOCAL_CFLAGS := -D_ANDROID_ -D__LINUX__

LOCAL_LDLIBS := -llog

LOCAL_SHARED_LIBRARIES += \
	libutils \
	libbinder \
	libcutils

LOCAL_PRELINK_MODULE := false

include $(BUILD_EXECUTABLE)
