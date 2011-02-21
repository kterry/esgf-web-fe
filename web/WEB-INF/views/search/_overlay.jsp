<%@ include file="/WEB-INF/views/common/include.jsp" %>

<!-- overlays -->
<div class="apple_overlay" id="temporal_overlay"><div class="contentWrap"></div></div>

<div class="apple_overlay" id="geospatial_overlay"><div class="contentWrap"></div></div>

<div class="apple_overlay" id="metadata_overlay"><div class="contentWrap"></div></div>

<div class="apple_overlay" id="annotator_overlay"><div class="contentWrap"></div></div>

<!--
<div class="apple_overlay" id="facet_overlay"><div class="contentWrap"></div></div>
-->

<!-- facet overlay -->
<!-- need to replace the following with a separate html -->

<div class="apple_overlay" id="facet_overlay">
    <div class="overlay_header" style="display:none">
        <div class="overlay_header_title">
            Category Browser
        </div>
        <!--
        <div class="overlay_header_buttons">
            <div id="facetSort">
                <input type="radio" id="sortbycount" name="sorter" checked="checked" value="sortbycount" /><label for="sortbycount">Sort By Count</label>
                <input type="radio" id="sortbyabc" name="sorter" value="sortbyabc" /><label for="sortbyabc">Sort By ABC</label>
            </div>
        </div>
        -->
    </div>
    <div class="overlay_border" style="display:none"></div>
    <div class="overlay_content" style="display:none">
		 <div id="actions1"> 
					<a class="prev">&laquo; Back</a> 
					<a class="next">More &raquo;</a> 
			</div>
           <div class="scrollable facet_verticalscroll">
            
            <div class="facet_items">
            	<div class="facet_item">
            		<div id="project"></div>
            	</div>
            	<div class="facet_item">
            		<div id="model"></div>
            	</div>
            	<div class="facet_item">
            		<div id="experiment"></div>
            	</div>
            	<div class="facet_item">
            		<div id="frequency"></div>
            	</div>
            	<div class="facet_item">
            		<div id="realm"></div>
            	</div>
            	<div class="facet_item">
            		<div id="instrument"></div>
            	</div>
            	<div class="facet_item">
            		<div id="variable"></div>
            	</div>
            	<div class="facet_item">
            		<div id="cf_variable"></div>
            	</div>
            	<div class="facet_item">
            		<div id="gcmd_variable"></div>
            	</div>
            </div>
        </div>
        
    </div>
    <div class="overlay_border" style="display:none"></div>
    <div class="overlay_footer" style="display:none">
        <div class="overlay_header_buttons">
        <!--  
            <div id="facetSort">
                <input type="radio" id="sortbycount" name="sorter" checked="checked" value="sortbycount" /><label for="sortbycount">Sort By Count</label>
                <input type="radio" id="sortbyabc" name="sorter" value="sortbyabc" /><label for="sortbyabc">Sort By ABC</label>
            </div>
        -->
        </div>
    </div>
</div>

<div id="temp-browse"></div>
<div id="metadata-browse"></div>