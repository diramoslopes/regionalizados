$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event){
	
	var button = $(event.relatedTarget);
	
	var codigoApoiador = button.data('codigo');
	var nomeApoiador = button.data('nome');
	
//	alert(codigoApoiador);
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	if(!action.endsWith('/')){
		action += '/';
	}
	form.attr('action', action + codigoApoiador);

// -----------------------
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir <strong>' + nomeApoiador + '</strong>?');
	
	
});

$(function () {
	  $('[rel="tooltip"]').tooltip();
	  
	  $('.js-atualizar-statusApoio').on('click', function(event){
		  event.preventDefault();
		  
		  var botaoConfirmarApoio = $(event.currentTarget);
		  var urlConfirmarApoio =  botaoConfirmarApoio.attr('href');
		  
//		  console.log('urlConfirmarApoio', urlConfirmarApoio);
		  
		  var response = $.ajax({
			  url: urlConfirmarApoio,
			  type: 'PUT'
		  });
		  
		  response.done(function(e){
			  var codigoApoiador = botaoConfirmarApoio.data('codigo');
			  $('[data-role=' + codigoApoiador + ']').html('<span class="label label-success">' + e + '</span>');
			  botaoConfirmarApoio.hide();
			  
		  });
		  
		  response.fail(function(e){
			  console.log(e);
			  alert('erro confirmar apoio');
		  })
		  
	  });
});