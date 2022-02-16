# Contributing to MessageEngine
Thank you for investing your time in contributing to our project! Please review these guidelines before making a pull request.
______

# README/Website pull requests

### MicroPRs, README edits, Typo fixes, Other MiniPRs
- MessageEngine is open to ALL pull requests as long as they are helpful (improve MessageEngine). We allow all types of MiniPRs as long as you follow our pull request guidelines.
- If you have a random idea, but don't want to open a PR, feel free to talk about it in our [Discord](https://disboard.org/server/893975758677086238)

### Allowed
- Typo/Grammar fixes
- Fixing a broken link
- Rewriting something that's confusing to make it more clear
- All helpful additions or changes

### Not Allowed
- Unnecessarily large changes
- Not helpful
- Troll/Useless/Spam changes
- Any PRs we close without merging, we have reasons.

______
# Java Pull Requests

### Don't change these files:
- **Anything you don't really need to change, don't change**. Randomly changing files is useless, and could be destructive if you don't know what you're doing.
- `Version.java` - `src/msg/version/Version.java` - Don't change the version, we'll do this ourselves.
- `version.yml` - `src/msg/version/version.yml` -  Don't change the version, we'll do this ourselves. UNLESS this file isn't up-to-date with Version.java
- `.gitignore` - `/.gitignore` - Don't change the .gitignore unless this is useful or necessary.


## Follow these steps to make your Pull Request

### Make your edits
1. **Use IntelliJ IDEA to make your edits**. This is because we've already made all the configuration we need to make changes.
2. **Make sure you didn't add any unnecessary files**. Check the `.idea` folder, IntelliJ IDEA tends to generate random files.
3. Once you've finished making your edits, make sure to **build the artifacts**. If you've done this successfully, `latest.jar` (in `/build/latest.jar`) will update.
4. **Actually test what you've made**. Non-tested PRs are quite worthless, because those only "theoretically" work.
5. **Check your changed files**. If something seems wrong, don't commit that file.

### Commit and push to your fork
1. **VERY IMPORTANT**: Please name your commits `MessageEngine Alpha`. You can type the info in the more details section.

### Open your pull request
1. Enable `Allow Updates from Maintainers`. Otherwise, we can't do small changes like update the version, or fix something that you did poorly. Chances are, we won't merge your PR if you don't enable this.
2. Provide a detailed description of your changes. Also, make a quality title that describes what you change.
3. Create your pull request.