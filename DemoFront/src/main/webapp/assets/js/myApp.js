var app=angular.module("myApp",[])
		
		app.controller("myCtrl",function($scope,$http){
			$scope.countries=[];
			
			$http.get("assets/js/countries.json").then(function(response){
				
				$scope.countries=response.data;
			},function(response){
				alert(response.data+' Fail !')
			});
		});