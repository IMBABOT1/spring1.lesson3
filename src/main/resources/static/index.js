angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app/api/v1';

    $scope.loadProducts = function (pageIndex = 1) {
        $http({
            url: contextPath + '/products',
            method: 'GET',
            params: {
                title_part: $scope.filter ? $scope.filter.title_part : null,
                min_price: $scope.filter ? $scope.filter.min_price : null,
                max_price: $scope.filter ? $scope.filter.max_price : null
            }
        }).then(function (response) {
            $scope.ProductsPage = response.data;
        });
    };


    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/products/delete/' + productId)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.addToCart = function (productId) {
        console.log(productId)
        $http.get(contextPath + '/cart/' + productId)
            .then(function (response){
            $scope.loadCartProducts();
        });
    }

    $scope.loadCartProducts = function () {
        $http.get(contextPath + '/cart')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };


    $scope.loadProducts();
});