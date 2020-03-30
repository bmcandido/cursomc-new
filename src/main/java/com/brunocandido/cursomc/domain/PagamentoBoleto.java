package com.brunocandido.cursomc.domain;

import java.util.Date;

import com.brunocandido.cursomc.enuns.EstadoPagamento;

public class PagamentoBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	private Date dataPagamento;
	private Date dataVencimento;

	public PagamentoBoleto() {

	}

	public PagamentoBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataPagamento, Date dataVencimento) {
		super(id, estado, pedido);
		this.setDataPagamento(dataPagamento);
		this.setDataVencimento(dataVencimento);

	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}
