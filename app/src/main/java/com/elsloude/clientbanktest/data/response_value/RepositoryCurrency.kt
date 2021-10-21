package com.elsloude.clientbanktest.data.response_value

import com.elsloude.clientbanktest.data.card_holder.ApiPlaceholder

class RepositoryCurrency(val api: ApiCurrency) {
    suspend fun getCurrency() = api.getCurrency()

}