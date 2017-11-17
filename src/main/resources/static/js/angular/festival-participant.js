var app = angular.module('app',[]);

app.controller('festivalController',function ($scope, $http, $window) {
    $scope.daftarParticipant = {};

    $scope.listParticipant = function(){
        $http.get('/festival/all').then(sukses,gagal);
        function sukses(response) {
            $scope.daftarParticipant = response.data;
            console.log('Response : '+response);
        }
        function gagal(response) {
            console.log('Error : '+response);
        }
    };
    $scope.listParticipant();

    $scope.registerFestivalParticipant = function(){
        $http.post('/festival/register',$scope.participant).then(sukses,gagal);
        function sukses(response){
            $window.location.href = '/festival-participant.html';
            console.log($scope.participant.toString())
        }
        function gagal(response){
            console.log('Data: ' +$scope.participant.toString())
            console.log('Error : '+response)
        }
    }
    $scope.updateFestivalParticipant = function(){
        $http.post('/festival/update',$scope.participant).then(sukses,gagal);
        function sukses(response){
            $window.location.href = '/festival-participant.html';
            console.log($scope.participant)
        }
        function gagal(response){
            console.log('Data: '+$scope.participant)
            console.log('Error : '+response)
        }
    }

    $scope.selectParticipant = function(participant){
        $scope.participant = participant
        console.log(participant)
    }

    $scope.deleteParticipant = function () {
        $http.post('/festival/delete/'+$scope.participant.id).then(sukses,gagal);
        function sukses(response){
            $window.location.href = '/festival-participant.html';
            console.log($scope.participant)
        }
        function gagal(response){
            console.log('Data: '+$scope.participant)
            console.log('Error : '+response)
        }
    }
})