# RefalFiveLambdaPlugin for IntelliJ IDEA

# Features
* Data Type Auto-completion
* Text highlighting
* Code commenting/uncommenting
* Brace matching
* Syntax and errors highlighting

## Authors
* Daria Tereshkina
* Alexander Konovalov

## Development notes
* In IDEA «Project structure…» set:
  * In «Project» tab: SDK «IntellJ IDEA 〈your edition〉»,
    project compiler output — `out` dir.
  * In «Modules» tab: sources: `gen` and `src`, excluded `out`,
    resources `resources`.
* In `.idea/RefalFiveLambdaPlugin.iml`:
  * change `"JAVA_MODULE"` to `"PLUGIN_MODULE"`.
* For building: «Build» → «Prepare Plugin Module For Deployment» and install
  `RefalFiveLambdaPlugin.jar` as plugin.
