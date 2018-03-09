angular.module("MyApp").directive("ngTranslateLanguageSelect",["LocaleService",function(e){"use strict";return{restrict:"A",replace:!0,template:'<div class="language-select" ng-if="visible"><label><select ng-init="currentLocaleDisplayName = localesDisplayNames[0]"ng-model="currentLocaleDisplayName" ng-options="localesDisplayName for localesDisplayName in localesDisplayNames" ng-change="changeLanguage(currentLocaleDisplayName)"></select></label></div>',controller:["$scope",function(a){a.currentLocaleDisplayName=e.getLocaleDisplayName(),a.localesDisplayNames=e.getLocalesDisplayNames(),a.visible=a.localesDisplayNames&&a.localesDisplayNames.length>1,a.changeLanguage=function(a){e.setLocaleByDisplayName(a)}}]}}]);