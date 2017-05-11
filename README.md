### Quick start

#### Initialization
```bash
git clone https://gitlab.intesys.it/tech-shared/bootcamp-reloaded-2017
cd bootcamp-reloaded-2017
blade gw initBundle
```
#### Jar Deployment (non osgi)
```bash
cd modules/bootcamp-permissions-checker
blade gw build
cp build/libs/*.jar ../bundles/tomcat-8.0.32/webapps/WEB-INF/libs
```

### Start Liferay
```bash
cd <liferay-home>
blade server start -b
```
#### Modules Deployment
```
blade -b modules/<nome-modulo> deploy
```