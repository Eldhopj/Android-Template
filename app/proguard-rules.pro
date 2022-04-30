# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#TODO : update package name
-keep class com.eldhopj.myapplication.domain.model.* { *; }

-keepnames class * extends android.os.Parcelable

-keepclassmembers enum * { *; }

#For enable only for debugging
#-keepattributes LocalVariableTable, LocalVariableTypeTable

#For keeping annotation
#-keepattributes *Annotation*, Signature, Exception
