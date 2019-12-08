import 'dart:async';

import 'package:flutter/services.dart';

class FlutterBleSwitch {
  static const MethodChannel _channel =
      const MethodChannel('flutter_ble_switch');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  /// Is BLE enable
  static Future<bool> isEnable() async {
    return await _channel.invokeMethod('isEnable');
  }

  /// Enable BLE
  static Future<bool> enable() async {
    return await _channel.invokeMethod('enable');
  }
}
