# Selenium Bidi

L'objectif de ce projet est d'apprendre à utiliser les possibilités offertes par WebDriver Bidi.

- [x] BasiAuth : permet de se connecter à une URL protégée par un htaccess. Le Webdriver intercepte la demande d'authentification et envoie les identifiants. Avec cette méthode il n'est plus nécessaire de transmettre les identifiants dans l'URL. Il est toujours possible d'envoyer les identifiants dans l'URL car les navigateurs désactivent les contrôles de sécurité pour faciliter les tests mais cela ne sera peut-être pas toujours le cas.
- [ ] user_context : permet d'exécuter plusieurs sessions au sein de la même instance du navigateur. Les epaces d'exécutions sont isolés. Cela permet d'économiser des ressources et d'augmenter le nombre de tests qui sont exécutes en parralléle.