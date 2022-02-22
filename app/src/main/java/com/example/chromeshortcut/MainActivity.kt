package com.example.chromeshortcut

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.robotemi.sdk.Robot
import com.robotemi.sdk.listeners.OnRobotReadyListener

class MainActivity : AppCompatActivity(), OnRobotReadyListener {
    private var mRobot: Robot = Robot.getInstance()
    private val TAG: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRobot = Robot.getInstance()
        startActivity(packageManager.getLaunchIntentForPackage("com.android.chrome"))

    }

    override fun onStart() {
        super.onStart()

        mRobot.addOnRobotReadyListener(this)
    }

    override fun onStop() {
        super.onStop()

        mRobot.removeOnRobotReadyListener(this)
    }

    override fun onRobotReady(isReady: Boolean) {
        if (isReady) {
            Log.i(TAG,"Robot is ready")
            mRobot.hideTopBar()
        }
    }
}