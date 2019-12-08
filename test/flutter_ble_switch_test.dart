import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_ble_switch/flutter_ble_switch.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_ble_switch');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FlutterBleSwitch.platformVersion, '42');
  });
}
