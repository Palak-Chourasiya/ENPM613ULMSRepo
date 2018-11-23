angular.module('ULMS')
  .component('baselayout', {
	transclude: true,
    templateUrl: 'components/baselayout/baselayouttemplate.html',
    bindings: {},

    controller: function() {

      var ctrl = this;

      this.$onInit = function() {

      };

    }
  })