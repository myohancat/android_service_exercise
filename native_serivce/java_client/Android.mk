LOCAL_PATH:= $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_SRC_FILES := $(call all-java-files-under, java) $(call all-Iaidl-files-under, aidl)

LOCAL_AIDL_INCLUDES := $(LOCAL_PATH)/aidl

LOCAL_PACKAGE_NAME := TestJavaClient

LOCAL_CERTIFICATE := platform

LOCAL_PROPRIETARY_MODULE := true

LOCAL_USE_AAPT2 := true
LOCAL_AAPT_FLAGS := \
    --auto-add-overlay \
    --extra-packages android.support.constraint

LOCAL_STATIC_ANDROID_LIBRARIES:= \
    android-support-constraint-layout

LOCAL_STATIC_JAVA_LIBRARIES := \
    androidx.appcompat_appcompat \
    android-support-constraint-layout-solver

include $(BUILD_PACKAGE)

# Use the folloing include to make our test apk.
include $(call all-makefiles-under,$(LOCAL_PATH))


