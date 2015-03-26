var monitor = angular.module('monitor', ['ngRoute', 'ngAnimate', 'libs']);

monitor.config(function($routeProvider) {
  $routeProvider
    .when('/', {
        templateUrl: 'public/html/demo.html',
        controller: 'MonitorDemo'
    })
    .when('/about', {
        templateUrl: 'public/html/about.html'
    })
    .otherwise({
        redirectTo:'/'
    });
});

monitor.controller('MonitorDemo', ['$scope', '$http', 'url', function($scope, $http, url){
    $scope.checkStatus = function() {
        if($scope.link) {
            $http.get('/monitor/api/rs/public/monitor/status?url='+url.encode($scope.link)).success(function(data) {
                $scope.site = data;
            });
        } else {
            $scope.site = undefined;
        }
    }
}]);