import SwiftUI
import Shared

@main
struct iOSApp: App {
    init() {
        AppInitializer().initialize()
    }

    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}