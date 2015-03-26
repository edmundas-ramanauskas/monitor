var libs = angular.module('libs', []);

libs.factory('storage', [ function() {
    return {
        map: {},
        set: function(key, value) {
            this.map[key] = value;
        },
        get: function(key) {
            return this.map[key];
        }
    }
}]);

libs.factory('url', [ function() {
    return {
        encode: function(link) {
            return encodeURIComponent(link).replace(/'/g,"%27").replace(/"/g,"%22");
        },
        decode: function(link) {
            return decodeURIComponent(link.replace(/\+/g,  " "));
        }
    }
}]);

libs.directive('zeroClipboard', ['storage', function(storage) {
    ZeroClipboard.config( { swfPath: "public/swf/ZeroClipboard.swf" } );
    return function(scope, element, attr) {
        var clipboard = new ZeroClipboard(element[0]);
        clipboard.on('copy', function(event) {
            event.clipboardData.setData('text/plain', storage.get(attr.zeroClipboard));
        });
    }
}]);