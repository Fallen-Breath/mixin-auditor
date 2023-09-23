# mixin-auditor

[![maven badge](https://maven.fallenbreath.me/api/badge/latest/releases/me/fallenbreath/mixin-auditor)](https://maven.fallenbreath.me/#/releases/me/fallenbreath/mixin-auditor)

A tiny mod to automatically trigger a `MixinEnvironment.getCurrentEnvironment().audit()` on Minecraft launch

It is available at [my maven](https://maven.fallenbreath.me/#/releases/me/fallenbreath/mixin-auditor)

It requires no dependencies, and should work in all Minecraft versions >= 1.14

## Usages

### Import

```groovy
repositories {
    maven { url 'https://maven.fallenbreath.me/releases' }
}

dependencies {
    modRuntimeOnly 'me.fallenbreath:mixin-auditor:0.1.0'
}
```

Normally mixin auditor should only be used in development environment, that's why `modRuntimeOnly` is use here

### Run

Run Minecraft with system property `-DmixinAuditor.audit=true`, and mixin auditor will handle the rest

Yeah, not with config file / API, cuz it's designed for development / CI environment, not for users in production
environment

Here's a simple examples to launch the server with mixin auditor enabled

```bash
export JAVA_TOOL_OPTIONS="$JAVA_TOOL_OPTIONS -DmixinAuditor.audit=true"
./gradlew runServer
```

### Loom

You can create a new loom run config for better integration with your gradle project

```gradle
loom {
    runs {
        // run server, but with mixin auditor enabled
        serverMixinAudit {
            server()
            vmArgs '-DmixinAuditor.audit=true'
        }
        
        // run client, but with mixin auditor enabled
        clientMixinAudit {
            client()
            vmArgs('-DmixinAuditor.audit=true', '-DmixinAuditor.when=game_init')
        }
    }
}
```

Then you can use the following gradle command to launch Minecraft server with mixin auditor enabled:

```bash
./gradlew runServerMixinAudit
./gradlew runClientMixinAudit
```

## Config

Mixin auditor can be configured with java system property

Available properties:

| Property                | Description                                                                                                                                                                               |
|-------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `mixinAuditor.audit`    | The main switch. Set it to `true` to enable mixin auditor, otherwise mixin auditor will do nothing                                                                                        |
| `mixinAuditor.when`     | When will mixin auditor triggers. Options: `mod_init`, fabric's `ModInitializer#onInitialize` hook; `game_init`, when the game is initialized and is about to start . Default: `mod_init` |
| `mixinAuditor.exit`     | If the Minecraft process should exit after auditing. Options: `true`, `false`, `on_fail`. Default: `true`                                                                                 |
| `mixinAuditor.failCode` | The return code to be used on exit if audit failed. It should be a valid integer. Default: `19`                                                                                           |
