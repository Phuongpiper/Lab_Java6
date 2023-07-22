let host = "https://demofirebase-693d5-default-rtdb.firebaseio.com";
const app = angular.module("myApp", []);

app.controller("myCtrl", function($scope, $http) {
  $scope.form = {};
  $scope.items = {};
  $scope.reset = function() {
    $scope.form = { gender: true, Country: "VN" };
    $scope.key = null; // Remove quotes around null
  };
  $scope.load_all = function() {
    var url = host + '/student.json';
    $http.get(url).then(
      function(resp) { // Corrected the syntax for success function
        $scope.items = resp.data;
        console.log("thanh cong", resp); // Add a comma after "thanh cong"
      },
      function(error) { // Corrected the syntax for error function
        console.log(error);
      }
    );
  };
  $scope.edit = function(key) {
    var url = host + `/student/${key}.json`; // Use backticks (`) instead of quotes ('') around the string.
    $http.get(url).then(resp => {
      $scope.form = resp.data;
      $scope.key = key;
      console.log("thanh cong", resp);

    }).catch(error => {
      console.log(error);
    });
  };
  
  $scope.create = function() {
    var item = angular.copy($scope.form);
    var url = host + '/student.json';
    $http.post(url, item).then(resp => {
        $scope.key=resp.data.name;
      $scope.items[$scope.key] = item;
      $scope.reset();
      console.log("thanh cong", resp);
    }).catch(error => {
      console.log(error);
    });
  };
  $scope.update = function() {
    var item = angular.copy($scope.form);
    var url = host + `/student/${$scope.key}.json`;
    $http.put(url, item).then(resp => {
      $scope.items[$scope.key] = resp.data; // Corrected the assignment
      console.log("thanh cong", resp);
    }).catch(error => {
      console.log(error);
    });
  };
  
  $scope.delete = function(key) {
    var url = host + `/student/${key}.json`;
    $http.delete(url).then(resp => {
      delete $scope.items[key];
      $scope.reset();
      console.log("thanh cong", resp);
    }).catch(error => {
      console.log(error);
    });
  };

  $scope.load_all();
  $scope.reset();
});
