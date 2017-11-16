var app = angular.module('app',[]);

app.controller('workshopController',function ($scope, $http, $window) {
    $scope.daftarParticipant = {};

    $scope.listParticipant = function(){
        $http.get('/workshop/all').then(sukses,gagal);
        function sukses(response) {
            $scope.daftarParticipant = response.data;
            console.log('Response : '+response);
        }
        function gagal(response) {
            console.log('Error : '+response);
        }
    };
    $scope.listParticipant();

    $scope.registerWorkshopParticipant = function(){
        $http.post('/workshop/register',$scope.participant).then(sukses,gagal);
        function sukses(response){
            $window.location.href = '/workshop-participant.html';
            console.log($scope.participant.toString())
        }
        function gagal(response){
            console.log('Data: ' +$scope.participant.toString())
            console.log('Error : '+response)
        }
    }
    $scope.updateWorkshopParticipant = function(){
        $http.post('/workshop/update',$scope.participant).then(sukses,gagal);
        function sukses(response){
            $window.location.href = '/workshop-participant.html';
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
})