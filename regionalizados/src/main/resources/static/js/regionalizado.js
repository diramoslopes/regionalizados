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