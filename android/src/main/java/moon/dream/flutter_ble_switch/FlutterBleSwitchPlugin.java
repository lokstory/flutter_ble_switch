package moon.dream.flutter_ble_switch;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * FlutterBleSwitchPlugin
 */
public class FlutterBleSwitchPlugin implements MethodCallHandler {
    /**
     * 藍芽Adapter
     */
    private BluetoothAdapter bluetoothAdapter;

    private Context context;

    /**
     * Plugin registration.
     */
    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(),
                                                        "flutter_ble_switch"
        );

        FlutterBleSwitchPlugin plugin = new FlutterBleSwitchPlugin();
        plugin.init(registrar);

        channel.setMethodCallHandler(plugin);
    }

    private void init(Registrar registrar) {
        context = registrar.context();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    @Override
    public void onMethodCall(MethodCall call, Result result) {
        switch (call.method) {
            case "getPlatformVersion":
                result.success("Android " + android.os.Build.VERSION.RELEASE);
                return;
            case "isEnable":
                isEnable(result);
                return;
            case "enable":
                enable(result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    /**
     * Is enable
     */
    private void isEnable(Result result) {
        try {
            result.success(bluetoothAdapter.enable());
        } catch (Exception e) {
            result.success(false);
        }
    }

    /**
     * Enable
     */
    private void enable(Result result) {
        try {
            bluetoothAdapter.enable();
            result.success(true);
        } catch (Exception e) {
            result.success(false);
        }
    }
}
