<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<rapid:override name="block-main">
<div id="loading" class="uk-width-1-1">
    <i class="uk-icon-spinner uk-icon-spin"></i>Loading...
</div>

<div id="vm" class="uk-width-1-1">
    <ul class="uk-tab" data-uk-tab>
        <li class="uk-active"><a href="#0">{{ _('Articles') }}</a></li>
        <li><a href="#0" onclick="location.assign('/manage/article/category_list')">Categories</a></li>
    </ul>

    <form v-on:submit.prevent="submit" class="uk-form uk-form-stacked uk-margin">
        <legend>{{ _(form.name) }}</legend>
        <fieldset>
            <div class="uk-alert uk-alert-danger uk-hidden"></div>
            <div class="uk-form-row">
                <label class="uk-form-label">Image:</label>
                <div class="uk-form-controls">
                    <div id="image-preview" style="border: 1px solid #ccc; width:642px; height:362px; background-size:cover;"></div>
                </div>
                <div class="uk-form-controls">
                    <input id="file" type="file">
                </div>
            </div>
            <div class="uk-form-row">
                <label class="uk-form-label">Name</label>
                <div class="uk-form-controls">
                    <input v-model="name" name="name" type="text" maxlength="100" class="uk-width-1-1" placeholder="name">
                </div>
            </div>
            <div class="uk-form-row">
                <label class="uk-form-label">Description</label>
                <div class="uk-form-controls">
                    <textarea v-model="description" name="description" rows="6" class="uk-width-1-1" style="resize:none;"></textarea>
                </div>
            </div>
            <div class="uk-form-row">
                <label class="uk-form-label">Category</label>
                <div class="uk-form-controls">
                    <select v-model="category_id" name="category_id" class="uk-width-1-1">
                        raw
                        <option v-for="category in categories" v-bind:value="category.id" v-text="category.name"></option>
                        endraw
                    </select>
                </div>
            </div>
            <div class="uk-form-row">
                <label class="control-label">Tags:</label>
                <div class="controls">
                    <input v-model="tags" name="tags" type="text" class="uk-width-1-1" placeholder="tag1, tag2, tag3">
                </div>
            </div>
            <div class="uk-form-row">
                <label class="control-label">Publish At:</label>
                <div class="controls">
                    <input v-once v-model="publish_date" name="publish_date" type="text" class="uk-width-1-6" data-uk-datepicker="{format:'YYYY-MM-DD', i18n:{ months:['{{ _('January') }}' , '{{ _('February') }}' , '{{ _('March') }}' , '{{ _('April') }}' , '{{ _('May') }}' , '{{ _('June') }}' , '{{ _('July') }}' , '{{ _('August') }}' , '{{ _('September') }}' , '{{ _('October') }}' , '{{ _('November') }}' , '{{ _('December') }}'], weekdays:['{{ _('Sun') }}' , '{{ _('Mon') }}' , '{{ _('Tue') }}' , '{{ _('Wed') }}' , '{{ _('Thu') }}' , '{{ _('Fri') }}' , '{{ _('Sat') }}'] } }">
                    <input v-once v-model="publish_time" name="publish_time"type="text" data-uk-timepicker>
                </div>
            </div>
            <div class="uk-form-row">
                <label class="control-label">Content:</label>
                <div class="controls">
                    <textarea id="content-editor" name="content" rows="20" style="width:100%; resize:none;"></textarea>
                </div>
            </div>
            <div class="uk-form-row">
                <div class="controls">
                    <button type="submit" class="uk-button uk-button-primary"><i class="uk-icon-check"></i>Save</button>
                    <button type="button" class="uk-button" onclick="location.assign()"><i class="uk-icon-times"></i> Cancel'</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</rapid:override>
<%@ include file="/WEB-INF/jsp/manage.jsp" %>
